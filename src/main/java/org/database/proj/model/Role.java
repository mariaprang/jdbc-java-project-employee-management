package org.database.proj.model;

public class Role {

    private int roleId;
    private String roleTitle;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    @Override
    public String toString() {
        return "roleId=" + roleId +
                        ", roleTitle='" + roleTitle;
    }
}
