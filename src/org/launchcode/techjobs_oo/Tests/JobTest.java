package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.launchcode.techjobs_oo.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.TimeZone;

import static org.junit.Assert.assertFalse;

public class JobTest {

    //@Before
    public Job job1 = new Job();
    public Job job2 = new Job();
    public Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    public Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobID(){
       assertFalse(this.job1.getId()==this.job2.getId());
    }

    @Test
    public void testJobID(){
        assertEquals(this.job2.getId(),job1.getId()+1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().toString());
        assertEquals("Desert", job3.getLocation().toString());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job3.getId()==job4.getId());
    }

    @Test
    public void testStartAndEndLine(){
        String[] s = job3.toString().split("");
        for (int i=0; i<s.length; i++){
            assertEquals(s[0],"\n");
            assertEquals(s[s.length-1], "\n");
        }
    }

    @Test
    public void noDataTest(){
        assertTrue(job1.getName()==null);
    }

    @Test
    public void noJobDataTest(){
        assertTrue(job1.getName()==null);
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
        System.out.println(job1);
    }

}
