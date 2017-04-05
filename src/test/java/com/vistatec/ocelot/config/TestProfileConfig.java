package com.vistatec.ocelot.config;

import java.io.File;
import java.io.StringWriter;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.vistatec.ocelot.config.json.ProfileConfig;


public class TestProfileConfig {

	@Test
	public void testReadProfile() throws TransferException, URISyntaxException{
		
		File confFile = new File(getClass().getResource("def_profile_cfg.json").toURI());
		ProfileConfigService confService = new ProfileConfigService(new ProfileConfigTransferService(confFile));
		Assert.assertTrue(confService.mustPromptMessage());
		Assert.assertEquals(ProfileConfig.DEFAULT_PROF_NAME, confService.getProfileName());
	}
	
	@Test
	public void testWriteProfile() throws TransferException, URISyntaxException {
		
		File confFile = new File(getClass().getResource("def_profile_cfg.json").toURI());
		StringWriter writer = new StringWriter();
		ProfileConfigService confService = new ProfileConfigService(new TestProfileConfigTransferService(confFile, writer));
		confService.changeActiveProfile("Test");
		String profString = "\"profile\" : \"Test\"";
		Assert.assertTrue(writer.toString().contains(profString));
		confService.doNotShowAgain();
		String msgString = "\"promptMessage\" : false";
		Assert.assertTrue(writer.toString().contains(msgString));
		
  
	}
}
