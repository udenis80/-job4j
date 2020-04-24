package ru.job4j.stream;

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
        return users.keySet().stream().filter(user -> user.getPassport().equals(passport)).findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> find = Optional.empty();
        if (user.isPresent()) {
            find = users.get(user).stream().filter(account -> account.getRequisite().equals(requisite)).findFirst();
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String requisiteDest, double amount) {
        boolean result = false;
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> outAccount = findByRequisite(destPassport, requisiteDest);
        if (account.isPresent() && outAccount.isPresent() && account.getBalance() >= amount) {
            account.setBalance((account.getBalance() - amount));
            outAccount.setBalance(outAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }
}