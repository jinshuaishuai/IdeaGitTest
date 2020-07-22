package com.jin.test;

/**
 * @author shuai.jin
 * @date 2020/7/15 14:39
 */
public enum SysUserAccountTypeEnum {

    ADMIN(1),NORMAL(0);

    int accountType;

    private SysUserAccountTypeEnum(int accountType) {
        this.accountType = accountType;
    }

    public int getAccountType() {
        return this.accountType;
    }
}
