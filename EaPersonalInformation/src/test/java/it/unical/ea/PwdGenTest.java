package it.unical.ea;

import it.unical.ea.model.PwdGen;

import static org.junit.Assert.*;

import org.junit.Test;

public class PwdGenTest {
	private static final String VALID_PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#$%=:\\?]).{4,50})";
	PwdGen pwdGen;
	
	public PwdGenTest() {
		pwdGen = new PwdGen();
	}
   
    @Test
    public void validatePassword_LettNumSpec() {
        String password = pwdGen.getPwdLettNumSpec();
        assertTrue(password.matches(VALID_PASSWORD_REGEX));
    }
    
//    @Test
//    public void validatePassword_lettersandnumbers() {
//        String password = "Abcdefg5";
//        boolean actual = PwdGen.validatePassword(password);
//        assertFalse(actual);
//    }
//
//    @Test
//    public void validatePassword_allcharacter() {
//        String password = "Abcdefg5A#";
//        boolean actual = PwdGen.validatePassword(password);
//        assertTrue(actual);
//    }
    
   }
