package com.pgichure.eprocure.setups.repositories;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import lombok.RequiredArgsConstructor;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@RequiredArgsConstructor
public class AddressRepositoryTest{

}
