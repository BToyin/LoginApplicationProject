package com.sparta.toyin.authentication;

import com.sparta.toyin.entities.User;
import com.sparta.toyin.entities.UserEntity;
import com.sparta.toyin.services.UserDAO;

import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.ArrayList;
import java.util.HashSet;

public class InMemoryIdentityStore implements IdentityStore {

//    private static ArrayList<String> adminUserNames;
//    private static ArrayList<String> adminPasswords;
//    private static ArrayList<String> userUserNames;
//    private static ArrayList<String> userPasswords;
//

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

        if (usernamePasswordCredential.getCaller().equals("mgadhvi") && usernamePasswordCredential.getPasswordAsString().equals("password")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("ADMIN");
            return new CredentialValidationResult("Manish", roles);
        } else if (usernamePasswordCredential.getCaller().equals("tajani") && usernamePasswordCredential.getPasswordAsString().equals("password")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("USER");
            return new CredentialValidationResult("Toyin", roles);
        } else {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
//
//        if (adminUserNames.contains(usernamePasswordCredential.getCaller()) && adminPasswords.contains(usernamePasswordCredential.getPasswordAsString())) {
//            HashSet<String> roles = new HashSet<>();
//            roles.add("ADMIN");
//            return new CredentialValidationResult("Manish", roles);
//        } else if (userUserNames.contains(usernamePasswordCredential.getCaller()) && userPasswords.contains(usernamePasswordCredential.getPasswordAsString())) {
//            HashSet<String> roles = new HashSet<>();
//            roles.add("USER");
//            return new CredentialValidationResult("Toyin", roles);
//        } else {
//            return CredentialValidationResult.NOT_VALIDATED_RESULT;
//        }
//    }
    }







}
