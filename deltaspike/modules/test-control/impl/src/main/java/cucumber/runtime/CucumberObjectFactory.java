/**
 *
 */
package cucumber.runtime;

import java.util.HashMap;
import java.util.Map;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import cucumber.api.java.ObjectFactory;

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
