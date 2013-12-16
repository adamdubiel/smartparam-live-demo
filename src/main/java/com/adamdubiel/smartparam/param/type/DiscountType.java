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

import com.adamdubiel.smartparam.domain.discount.Discount;
import org.smartparam.engine.annotated.annotations.ParamType;
import org.smartparam.engine.core.type.Type;

/**
 *
 * @author Adam Dubiel
 */
@ParamType("discount")
public class DiscountType implements Type<DiscountHolder> {

    public String encode(DiscountHolder holder) {
        return holder.getString();
    }

    public DiscountHolder decode(String text) {
        return new DiscountHolder(new Discount(Long.parseLong(text)));
    }

    public DiscountHolder convert(Object obj) {
        if (obj != null && Discount.class.isAssignableFrom(obj.getClass())) {
            return new DiscountHolder((Discount) obj);
        }

        if (obj == null) {
            return new DiscountHolder(null);
        }

        throw new IllegalArgumentException("conversion not supported for: " + obj.getClass());
    }

    public DiscountHolder[] newArray(int size) {
        return new DiscountHolder[size];
    }

}
