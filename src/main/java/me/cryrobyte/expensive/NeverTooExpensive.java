package me.cryrobyte.expensive;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeverTooExpensive implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("nevertooexpensive");

	@Override
	public void onInitialize() {
		LOGGER.info("NeverTooExpensive made by CryroByte, because he was annoyed!");
	}
}
