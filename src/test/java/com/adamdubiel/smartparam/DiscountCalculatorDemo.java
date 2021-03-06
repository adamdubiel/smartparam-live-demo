/*
 * Copyright 2013 Adam Dubiel, Przemek Hertel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adamdubiel.smartparam;

import com.adamdubiel.smartparam.config.RootContext;
import com.adamdubiel.smartparam.domain.User;
import com.adamdubiel.smartparam.domain.UserAccountType;
import com.adamdubiel.smartparam.domain.UserLogin;
import com.adamdubiel.smartparam.domain.discount.Discount;
import com.adamdubiel.smartparam.domain.discount.DiscountCalculator;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.smartparam.engine.test.ParamEngineAssertions.assertThat;

/**
 *
 * @author Adam Dubiel
 */
@ContextConfiguration(classes = RootContext.class)
public class DiscountCalculatorDemo extends AbstractTestNGSpringContextTests {

    @Autowired
    private DiscountCalculator discountCalculator;

    @Autowired
    private TestDateProvider dateProvider;

    @Test
    public void demonstrateDiscountCalculationForPrzemek() {
        // given
        dateProvider.servedDate(2013, 12, 17);

        User user = new User(new UserLogin("przemek"), new LocalDate(2013, 11, 23), UserAccountType.PREMIUM);

        // when
        Discount discount = discountCalculator.calculateForUser(user);

        // then
        assertThat(discount.value()).isEqualTo(70);
    }

    @Test
    public void demonstrateDiscountCalculationForAdam() {
        // given
        dateProvider.servedDate(2013, 12, 17);

        User user = new User(new UserLogin("adam"), new LocalDate(2013, 11, 23), UserAccountType.REGULAR);

        // when
        Discount discount = discountCalculator.calculateForUser(user);

        // then
        assertThat(discount.value()).isEqualTo(10);
    }
}
