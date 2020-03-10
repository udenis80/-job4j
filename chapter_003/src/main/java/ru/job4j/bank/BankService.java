package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        User user1 = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                user1 = user;
            }
        }
        return user1;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account1 = null;
        List<Account> accountList = users.get(findByPassport(passport));
        for (Account account : accountList) {
            if (account.getRequisite().equals(requisite)) {
                account1 = account;
            }
        }
        return account1;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean result = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account outAccount = findByRequisite(destPassport, dеstRequisite);
        if (account != null && outAccount != null) {
            account.transfer(outAccount, amount);
            result = true;
        }
        return result;
    }
}