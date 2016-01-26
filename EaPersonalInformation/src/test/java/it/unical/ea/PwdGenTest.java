package it.unical.ea;

import it.unical.ea.model.PwdGen;

import static org.junit.Assert.*;

import org.junit.Test;

public class PwdGenTest {
	
	public PwdGenTest() {
	}

   
    @Test
    public void validatePassword_missingnumbers() {
        String password = "Abcdefg#";
        boolean actual = PwdGen.validatePassword(password);
      assertFalse(actual);
    }
    
    @Test
    public void validatePassword_lettersandnumbers() {
        String password = "Abcdefg5";
        boolean actual = PwdGen.validatePassword(password);
        assertFalse(actual);
    }

    @Test
    public void validatePassword_allcharacter() {
        String password = "Abcdefg5A#";
        boolean actual = PwdGen.validatePassword(password);
        assertTrue(actual);
    }
    
   }
