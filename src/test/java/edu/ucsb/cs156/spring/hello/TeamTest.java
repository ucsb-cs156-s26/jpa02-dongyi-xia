package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_Case_1() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_Case_2() {
        int a = 8;
        assertFalse(team.equals(a));
    }

    @Test
    public void equals_Case_3_TT() {
        Team team_test1 = new Team("test-team");
        assertTrue(team.equals(team_test1));
    }

    @Test
    public void equals_Case_3_TF() {
        Team team_test1 = new Team("test-team");
        team_test1.setMembers(new ArrayList<>(Arrays.asList("Alice", "Bob")));
        assertFalse(team.equals(team_test1));
    }

    @Test
    public void equals_Case_3_FT() {
        Team team_test1 = new Team("Hawaii");
        assertFalse(team.equals(team_test1));
    }

    @Test
    public void equals_Case_3_FF() {
        Team team_test1 = new Team("Hawaii");
        team_test1.setMembers(new ArrayList<>(Arrays.asList("Alice", "Bob")));
        assertFalse(team.equals(team_test1));
    }

    @Test
    public void hashCode_equals() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_correct_hasahCode() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
   


}
