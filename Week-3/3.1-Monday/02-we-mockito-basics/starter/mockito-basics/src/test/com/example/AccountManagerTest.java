package com.example;

import org.junit.Before;
import org.junit.Test;

import java.text.Format;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AccountManagerTest {
    private FormatChecker formatChecker;
    private AccountRepository accountRepository;

    private AccountManager accountManager;

    private static final String badPassword = "abcde";
    private static final String goodUsername1 = "username";
    private static final String goodUsername2 = "eightCharacterUsername";
    private static final String badUsername = "bad";
    private static final String goodPassword1 = "passw0rd";
    private static final String goodPassword2 = "78v783289v72987v2";

    @Before
    public void setUp() {
        formatChecker = mock(FormatChecker.class);
        doReturn(true).when(formatChecker).ValidateUsername(goodUsername1);
        doReturn(true).when(formatChecker).ValidateUsername(goodUsername2);
        doReturn(false).when(formatChecker).ValidateUsername(badUsername);
        doReturn(true).when(formatChecker).ValidatePassword(goodPassword1);
        doReturn(true).when(formatChecker).ValidatePassword(goodPassword2);
        doReturn(false).when(formatChecker).ValidatePassword(badPassword);

        accountRepository = mock(AccountRepository.class);
        doReturn(true).when(accountRepository).CreateAccount(anyString(), anyString());

        accountManager = new AccountManager(formatChecker, accountRepository);
    }

    @Test
    public void shouldCreateANewAccountWithoutMockObjects() {
        SimpleFormatChecker simpleFormatChecker = new SimpleFormatChecker();
        // FormatChecker  simpleFormatChecker = new SimpleFormatChecker();  // FormatChecker is-a  SimpleFormatChecker
        SimpleAccountRepository simpleAccountRepository = new SimpleAccountRepository();
        // AccountRepository simpleAccountRepository = new SimpleAccountRepository(); // SimpleAccountRepository is-a AccountRepository

        AccountManager accountManager = new AccountManager(simpleFormatChecker, simpleAccountRepository);

        assert(accountManager.CreateNew("username", "passw0rd"));
    }

    @Test
    public void shouldCreateNewAccount() {

        assert(accountManager.CreateNew(goodUsername1, goodPassword1));
        assert(accountManager.CreateNew(goodUsername2, goodPassword2));
    }

    @Test
    public void shouldFailToCreateAccountWithInvalidUsername() {
        assertFalse(accountManager.CreateNew(badUsername, goodPassword1));
    }

    @Test
    public void shouldFailToCreateAccountWithInvalidPassword() {
        assertFalse(accountManager.CreateNew(goodUsername2, badPassword));
    }

    @Test
    public void shouldCallValidateAndCreateNewVerifiedWithSpies(){
        FormatChecker spyFormatChecker = spy(SimpleFormatChecker.class);
        AccountRepository spyAccountRepository = spy(SimpleAccountRepository.class);
        AccountManager spiedUponAccountManager = new AccountManager(spyFormatChecker, spyAccountRepository);
        spiedUponAccountManager.CreateNew("username", "passw0rd");
        spiedUponAccountManager.CreateNew("username2", "passw0rd2");

        //call spiedUponAccountManager to check and verify
        verify(spyFormatChecker).ValidateUsername("username");
        verify(spyFormatChecker).ValidatePassword("passw0rd2");

        verify(spyFormatChecker,times(2)).ValidateUsername(anyString());

    }
}






//    private FormatChecker formatChecker;
//    private AccountRepository accountRepository;
//    private AccountManager accountManager;
//    private static final String badPassword = "abcs";
//    @Test
//    public void shouldCreateANewAccountWithoutMockObjects(){
//
//    }
//
//    @Test
//    public void setUp(){
//        FormatChecker formatChecker = mock(FormatChecker.class);
//        doReturn(true).when(formatChecker).ValidateUsername("username");
//        doReturn(true).when(formatChecker).ValidatePassword("passw0rd");
//        doReturn(true).when(formatChecker).ValidateUsername("eightCharacterUsername");
//        doReturn(true).when(formatChecker).ValidatePassword("passw0rd");
//
//        doReturn(true).when(formatChecker).ValidatePassword("passw0rd");
//        doReturn(true).when(formatChecker).ValidatePassword("48484ujijij");
//
//         accountRepository = mock(AccountRepository.class);
//        doReturn(true).when(accountRepository).CreateAccount(anyString(), anyString());
//
//
//         accountManager = new AccountManager(formatChecker, accountRepository);
//
////        assert(accountManager.CreateNew("username", "passw0rd"));
//        assert(accountManager.CreateNew("eightCharacterUsername", "48484ujijij"));
//
//    }
//
//    @Test
//    public void shouldCreateNewAccount(){
//       assert(accountManager.CreateNew("eightCharacterUsername","48484ujijij" ));
//    }
//
//    @Test
//    public void shouldFailToCreateAccountWithInvalidUserName(){
//        assertFalse(accountManager.CreateNew("bad", ));
//    }
