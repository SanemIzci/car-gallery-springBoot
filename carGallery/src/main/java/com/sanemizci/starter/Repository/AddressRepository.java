package com.sanemizci.starter.Repository;

import com.sanemizci.starter.Dto.DtoAddress;
import com.sanemizci.starter.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
