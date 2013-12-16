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

import com.adamdubiel.smartparam.domain.DateProvider;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Dubiel
 */
@Service("testDateProvider")
public class TestDateProvider implements DateProvider {

    private LocalDate servedDate;

    @Override
    public LocalDate currentDate() {
        return servedDate;
    }

    public void servedDate(int year, int month, int day) {
        this.servedDate = new LocalDate(year, month, day);
    }
}
