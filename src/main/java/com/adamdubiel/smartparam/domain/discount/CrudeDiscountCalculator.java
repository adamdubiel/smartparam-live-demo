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
package com.adamdubiel.smartparam.domain.discount;

import com.adamdubiel.smartparam.domain.DateProvider;
import com.adamdubiel.smartparam.domain.User;
import com.adamdubiel.smartparam.domain.UserAccountType;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Dubiel
 */
@Service
public class CrudeDiscountCalculator implements DiscountCalculator {

    private final DateProvider dateProvider;

    @Autowired
    public CrudeDiscountCalculator(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public Discount calculateForUser(User user) {
        long discountValue = 0;
        LocalDate today = dateProvider.currentDate();

        if (today.isBefore(new LocalDate(2013, 12, 01))) {
            if (user.accountType() == UserAccountType.PREMIUM) {
                discountValue = 15;
            } else if (user.accountType() == UserAccountType.REGULAR) {
                discountValue = 5;
            }
        }

        return new Discount(discountValue);
    }
}
