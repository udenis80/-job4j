package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();
    private HashSet<Account> accounts = new HashSet<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
    users.get(findByPassport(passport)).add(account);
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (users.get(passport).equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accountList = users.get(findByPassport(passport));
        for (Account account : accountList) {
            if (account.getRequisite().equals(account)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}