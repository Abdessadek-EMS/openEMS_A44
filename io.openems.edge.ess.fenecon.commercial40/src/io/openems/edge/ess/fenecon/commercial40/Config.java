package io.openems.edge.ess.fenecon.commercial40;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(//
		name = "ESS FENECON Commercial 40", //
		description = "Implements the FENECON Commercial 40 energy storage system.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "ess0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Read-Only mode", description = "Enables Read-Only mode")
	boolean readOnlyMode() default false;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus bridge.")
	String modbus_id() default "modbus0";

	@AttributeDefinition(name = "Power limit on PowerDecreaseCausedByOvertemperature error; '0' to disable power limit logic", description = "")
	int powerLimitOnPowerDecreaseCausedByOvertemperatureChannel() default 20_000;

	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "(enabled=true)";

	@AttributeDefinition(name = "Surplus Feed-In: State-of-Charge limit", description = "Start Surplus-feed-in if State-of-Charge is bigger than this limit")
	int surplusFeedInSocLimit() default 90;

	@AttributeDefinition(name = "Surplus Feed-In: Allowed-Charge-Power limit", description = "Start Surplus-feed-in if Charge-Power is smaller than this limit. (Needs to set negative)")
	int surplusFeedInAllowedChargePowerLimit() default -8_000;

	@AttributeDefinition(name = "Surplus Feed-In: Increase Power by percentage", description = "1.1 for 10 %")
	double surplusFeedInIncreasePowerFactor() default 1.1;

	@AttributeDefinition(name = "Surplus Feed-In: Max increase Power", description = "")
	int surplusFeedInMaxIncreasePowerFactor() default 2_000;

	@AttributeDefinition(name = "Surplus Feed-In: Off Time", description = "The time to stop grid feed in.")
	String surplusFeedInOffTime() default "17:00:00";

	@AttributeDefinition(name = "Surplus Feed-In: PV-Limit on PowerDecreaseCausedByOvertemperature", description = "")
	int surplusFeedInPvLimitOnPowerDecreaseCausedByOvertemperature() default 5_000;

	String webconsole_configurationFactory_nameHint() default "ESS FENECON Commercial 40 [{id}]";
}
