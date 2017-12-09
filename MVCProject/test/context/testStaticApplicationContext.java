package context;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

public class testStaticApplicationContext {

	@Test
	public void testApplicationContext_Hello_클래스_빈_등록(){
			
		StaticApplicationContext ac = new StaticApplicationContext();
		ac.registerSingleton("hello1", Hello.class);
		
		Hello hello1 = ac.getBean("hello1",Hello.class);
//		assertThat(hello1,is(not(null)));
		assertTrue(hello1 != null);
	}
	
	@Test
	public void testBeanDefinition_Hello_클래스_BeanDefinition등록() throws Exception {
		StaticApplicationContext ac = new StaticApplicationContext();
		
		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		helloDef.getPropertyValues().addPropertyValue("name","Spring");
		ac.registerBeanDefinition("hello2", helloDef);
		
		Hello hello2 = ac.getBean("hello2",Hello.class);
		System.out.println(hello2.sayHello());
		System.out.println(ac.getBeanFactory().getBeanDefinitionCount());
		assertThat(hello2.sayHello(),is("Hello Spring"));
		
	}
	
	@Test
	public void registerBeanWithDependency() throws Exception {
		StaticApplicationContext ac = new StaticApplicationContext();
		
		ac.registerBeanDefinition("printer", 
				new RootBeanDefinition(StringPrinter.class));
		
		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		helloDef.getPropertyValues().addPropertyValue("name","Spring");
		helloDef.getPropertyValues().addPropertyValue("printer",
				new RuntimeBeanReference("printer"));
		
		ac.registerBeanDefinition("hello", helloDef);
		
		Hello hello = ac.getBean("hello",Hello.class);
		hello.print();
		
		assertThat(ac.getBean("printer").toString(),is("Hello Spring"));
	}
	
	@Test
	public void genericApplicationContext() throws Exception {
		GenericApplicationContext ac = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
		reader.loadBeanDefinitions("context/genericApplicationContext.xml");

		//책에서는 코딩하라고 나오는데 코딩하지 않았을 경우 실행이된다.
//		ac.refresh();
		
		Hello hello = ac.getBean("hello",Hello.class);
		hello.print();
		
		System.out.println(ac.getBean("printer").toString());
	}
}
