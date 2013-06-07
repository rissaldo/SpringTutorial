/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springhib.dao;

import com.springhib.model.Team;
import java.util.List;

/**
 *
 * @author rissaldo
 */
public interface TeamDAO {
    
    public void addTeam(Team team);
    public void updateTeam(Team team);
    public Team getTeam(int id);
    public void deleteTeam(int id);
    public List<Team> getTeams();
    
}
