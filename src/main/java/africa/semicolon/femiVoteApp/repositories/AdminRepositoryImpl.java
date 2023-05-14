package africa.semicolon.femiVoteApp.repositories;
import africa.semicolon.femiVoteApp.models.Address;
import africa.semicolon.femiVoteApp.models.Admin;
import africa.semicolon.femiVoteApp.models.UserInformation;
import africa.semicolon.femiVoteApp.utils.AppUtils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository{
    private List<Admin> admins = new ArrayList<>();

    @Override
    public Admin findById(String id) {
        //return admins.stream().filter(admin -> admin.getId().equals(id)).findFirst().orElse(null);
        for (Admin admin:admins) {
            if (admin.getId().equals(id)) return admin;
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

    @Override
    public Admin save(Admin admin) {
        String id = AppUtils.generateId();
        admin.setId(id);
        boolean isAdminWithUserInformation = admin.getUserInformation() != null;
        if (isAdminWithUserInformation){
            UserInformation userInformation = admin.getUserInformation();
            userInformation.setId(AppUtils.generateId());
            admin.setUserInformation(userInformation);
        }
        admins.add(admin);
        return admin;
    }

    @Override
    public void deleteById(String id) {
        Admin admin = findById(id);
        if(admin != null) admins.remove(admin);
    }
}
