

### All Types

| Name | Summary |
|---|---|
|

##### [dev.toliner.yokaidrone.api.Abilities](../dev.toliner.yokaidrone.api/-abilities.md)


|

##### [dev.toliner.yokaidrone.api.Ability](../dev.toliner.yokaidrone.api/-ability/index.md)

Ability is a configurable function for [Yokai](../dev.toliner.yokaidrone.api/-yokai/index.md).
When the Ability is gained by [Yokai](../dev.toliner.yokaidrone.api/-yokai/index.md), it should configure [JDABuilder](https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/JDABuilder.html)
based on config to capture event from Discord.
**All implementation should be object-declaration**


|

##### [dev.toliner.yokaidrone.api.AbilityConfig](../dev.toliner.yokaidrone.api/-ability-config.md)

Empty interface for configuration of [Ability](../dev.toliner.yokaidrone.api/-ability/index.md).


|

##### [dev.toliner.yokaidrone.ability.CommandHandlingAbility](../dev.toliner.yokaidrone.ability/-command-handling-ability/index.md)


|

##### [dev.toliner.yokaidrone.api.DependencyMap](../dev.toliner.yokaidrone.api/-dependency-map/index.md)


|

##### [dev.toliner.yokaidrone.data.DroneModule](../dev.toliner.yokaidrone.data/-drone-module/index.md)


|

##### [dev.toliner.yokaidrone.MessageType](../dev.toliner.yokaidrone/-message-type/index.md)


|

##### [dev.toliner.yokaidrone.api.Yokai](../dev.toliner.yokaidrone.api/-yokai/index.md)

Interface for Yokai, which is one set of bot functions.
The first thing you should do when you build bot is choose or implement Yokai.
Yokai must be specified by command-line argument, then all specified Yokai is loaded by bootstrap.
Each Yokai can have some [Ability](../dev.toliner.yokaidrone.api/-ability/index.md).
You can gain and configure [Ability](../dev.toliner.yokaidrone.api/-ability/index.md)s by overriding [init](../dev.toliner.yokaidrone.api/-yokai/init.md) method.
**All implementation must have non-parameter constructor.**


|

##### [dev.toliner.yokaidrone.data.YokaiDroneContext](../dev.toliner.yokaidrone.data/-yokai-drone-context/index.md)


