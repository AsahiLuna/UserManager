package com.asahi.usermanager.user.model;

public class UserSearchCondition {

    public UserSearchCondition() {}
    
    public UserSearchCondition(String name, int pageNumber, int pageSize, int isDeleted) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.isDeleted = isDeleted;
    }
    

    private String name;
    
    private int pageNumber;
    
    private int pageSize;

    private int isDeleted;
    
    
    @Override
    public String toString() {
        return "UserSearchCondition [name=" + name + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
                + ", isDeleted=" + isDeleted + "]";
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
}
