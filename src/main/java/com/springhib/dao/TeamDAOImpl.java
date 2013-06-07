
package com.springhib.dao;

import com.springhib.model.Team;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOImpl implements TeamDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addTeam(Team team) {
        getCurrentSession().save(team);
    }

    @Override
    public void updateTeam(Team team) {
        Team teamToUpdate = getTeam(team.getId());
        teamToUpdate.setName(team.getName());
        teamToUpdate.setRating(team.getRating());        
        getCurrentSession().update(team);
    }

    @Override
    public Team getTeam(int id) {
        return (Team) getCurrentSession().get(Team.class, id);
    }

    @Override
    public void deleteTeam(int id) {
        Team team = getTeam(id);
        
        if(team != null)
            getCurrentSession().delete(id);
        
    }

    @Override
    public List<Team> getTeams() {
        return getCurrentSession().createQuery("from Team").list();
    }
    
}
