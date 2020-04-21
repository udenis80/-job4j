package ru.job4j.stream;

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
        return users.keySet().stream().filter(user -> user.getPassport().equals(passport)).findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account find = null;
        if (user != null) {
            find = users.get(user).stream().filter(account -> account.getRequisite().equals(requisite)).findFirst().orElse(null);
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String requisiteDest, double amount) {
        boolean result = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account outAccount = findByRequisite(destPassport, requisiteDest);
        if (account != null && outAccount != null) {
            account.transfer(outAccount, amount);
            result = true;
        }
        return result;
    }
}