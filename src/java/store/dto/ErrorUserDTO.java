/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.dto;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ErrorUserDTO implements Serializable{
    private String usernameError, passwordError, roleError;

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public ErrorUserDTO(String usernameError, String passwordError, String roleError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.roleError = roleError;
    }

    public ErrorUserDTO() {
    }
}
