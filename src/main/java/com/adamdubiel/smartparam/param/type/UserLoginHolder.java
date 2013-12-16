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
package com.adamdubiel.smartparam.param.type;

import com.adamdubiel.smartparam.domain.UserLogin;
import org.smartparam.engine.core.type.AbstractHolder;

/**
 *
 * @author Adam Dubiel
 */
public class UserLoginHolder extends AbstractHolder {

    private final UserLogin userLogin;

    UserLoginHolder(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public UserLogin getValue() {
        return userLogin;
    }

    @Override
    public String getString() {
        return userLogin.value();
    }

}
