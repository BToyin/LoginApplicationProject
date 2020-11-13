package com.sparta.toyin.authentication;

import com.sparta.toyin.entities.UserEntity;
import com.sparta.toyin.services.UserDAO;

import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

public class InMemoryIdentityStore implements IdentityStore {


    @Inject
    private UserDAO userDAO;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

//        for (UserEntity admin : userDAO.findAdminsByRole()) {
//            if (usernamePasswordCredential.getCaller().equals(admin.getUserName()) && usernamePasswordCredential.getPasswordAsString().equals(admin.getPassword())) {
//                HashSet<String> roles = new HashSet<>();
//                roles.add("ADMIN");
//                return new CredentialValidationResult(admin.getFirstName(), roles);
//            }
//        }
//        for (UserEntity user : userDAO.findUsersByRole()) {
//            if (usernamePasswordCredential.getCaller().equals(user.getUserName()) && usernamePasswordCredential.getPasswordAsString().equals(user.getPassword())) {
//                HashSet<String> roles = new HashSet<>();
//                roles.add("USER");
//                return new CredentialValidationResult(user.getFirstName(), roles);
//            }
//        }
//        return CredentialValidationResult.NOT_VALIDATED_RESULT;
//    }
//
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
}

}
