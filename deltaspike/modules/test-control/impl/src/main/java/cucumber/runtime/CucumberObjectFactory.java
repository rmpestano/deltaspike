/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cucumber.runtime;

import cucumber.api.java.ObjectFactory;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafael-pestano on 05/10/2015.
 */
public class CucumberObjectFactory implements ObjectFactory
{

    private Map<Class, Object> definitions = new HashMap<Class, Object>();

    @Override
    public void start()
    {
    }

    @Override
    public void stop()
    {
        definitions.clear();
    }

    @Override
    public boolean addClass(Class<?> aClass)
    {
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> clazz)
    {
        if (definitions.get(clazz) == null)
        {
            definitions.put(clazz, BeanProvider.getContextualReference(clazz, false));
        }
        return (T) definitions.get(clazz);
    }


}
