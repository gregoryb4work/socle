package fr.gba.socle.generique.metaparameter.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gba.socle.generique.metaparameter.MetaParameterApplicationTests;
import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;
import fr.gba.socle.generique.metaparameter.dto.MetaParameterDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MetaParameterApplicationTests.class)
public class MetaParameterDomainTest {

	@Test
	public void testComparatorParamMetier() throws Exception {
		MetaParameterDto paramMetier1 = new MetaParameterDto(MetaParameterKey.EXAMPLE_1, "1");
		MetaParameterDto paramMetier2 = new MetaParameterDto(MetaParameterKey.EXAMPLE_2, "1");
		Assert.assertEquals(paramMetier1.compare(paramMetier1, paramMetier2), -4);

	}

}
