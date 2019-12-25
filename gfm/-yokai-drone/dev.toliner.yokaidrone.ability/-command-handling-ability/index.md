[YokaiDrone](../../index.md) / [dev.toliner.yokaidrone.ability](../index.md) / [CommandHandlingAbility](./index.md)

# CommandHandlingAbility

`object CommandHandlingAbility : `[`Ability`](../../dev.toliner.yokaidrone.api/-ability/index.md)`<Config>` [(source)](https://github.com/toliner/YokaiDrone/tree/master/src/main/kotlin/dev/toliner/yokaidrone/ability/CommandHandlingAbility.kt#L31)

### Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | `class Config : `[`AbilityConfig`](../../dev.toliner.yokaidrone.api/-ability-config.md) |

### Properties

| Name | Summary |
|---|---|
| [prefix](prefix.md) | `var prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [dependencies](dependencies.md) | `fun `[`DependencyMap`](../../dev.toliner.yokaidrone.api/-dependency-map/index.md)`.dependencies(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [gainedByYokai](gained-by-yokai.md) | Configure Ability and [builder](../../dev.toliner.yokaidrone.api/-ability/gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/builder) for [yokai](../../dev.toliner.yokaidrone.api/-ability/gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/yokai) based on [config](../../dev.toliner.yokaidrone.api/-ability/gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/config)`fun gainedByYokai(yokai: `[`Yokai`](../../dev.toliner.yokaidrone.api/-yokai/index.md)`, config: Config, builder: `[`JDABuilder`](https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/JDABuilder.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDefaultConfig](get-default-config.md) | `fun getDefaultConfig(): Config` |
