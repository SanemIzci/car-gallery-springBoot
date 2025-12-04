package com.sanemizci.starter.Repository;

import com.sanemizci.starter.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
