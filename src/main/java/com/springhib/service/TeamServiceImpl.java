
package com.springhib.service;

import com.springhib.dao.TeamDAO;
import com.springhib.model.Team;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamDAO teamDAO;
    
    @Override
    public void addTeam(Team team) {
        teamDAO.addTeam(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }

    @Override
    public Team getTeam(int id) {
        return teamDAO.getTeam(id);
    }

    @Override
    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);
    }

    @Override
    public List<Team> getTeams() {
        return teamDAO.getTeams();
    }
    
}
