package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport).isPresent()) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional result = Optional.empty();
        for (var user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = Optional.of(user);
                break;
            }
        }
        return result;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> result = Optional.empty();
        List<Account> accountList = users.get(findByPassport(passport));
        for (var account : accountList) {
            if (account.getRequisite().equals(requisite)) {
                result = Optional.of(account);
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String requisiteDest, double amount) {
        boolean result = false;
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> outAccount = findByRequisite(destPassport, requisiteDest);
        if (account.isPresent() && outAccount.isPresent()) {
            account.get().transfer(outAccount, amount);
            result = true;
        }
        return result;
    }
}