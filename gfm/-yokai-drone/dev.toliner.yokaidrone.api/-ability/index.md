[YokaiDrone](../../index.md) / [dev.toliner.yokaidrone.api](../index.md) / [Ability](./index.md)

# Ability

`interface Ability<T : `[`AbilityConfig`](../-ability-config.md)`>` [(source)](https://github.com/toliner/YokaiDrone/tree/master/src/main/kotlin/dev/toliner/yokaidrone/api/Ability.kt#L20)

Ability is a configurable function for [Yokai](../-yokai/index.md).
When the Ability is gained by [Yokai](../-yokai/index.md), it should configure [JDABuilder](https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/JDABuilder.html)
based on config to capture event from Discord.
**All implementation should be object-declaration**

**Author**
toliner

### Functions

| Name | Summary |
|---|---|
| [dependencies](dependencies.md) | `abstract fun `[`DependencyMap`](../-dependency-map/index.md)`.dependencies(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [gainedByYokai](gained-by-yokai.md) | Configure Ability and [builder](gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/builder) for [yokai](gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/yokai) based on [config](gained-by-yokai.md#dev.toliner.yokaidrone.api.Ability$gainedByYokai(dev.toliner.yokaidrone.api.Yokai, dev.toliner.yokaidrone.api.Ability.T, net.dv8tion.jda.api.JDABuilder)/config)`abstract fun gainedByYokai(yokai: `[`Yokai`](../-yokai/index.md)`, config: T, builder: `[`JDABuilder`](https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/JDABuilder.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDefaultConfig](get-default-config.md) | `abstract fun getDefaultConfig(): T` |

### Inheritors

| Name | Summary |
|---|---|
| [CommandHandlingAbility](../../dev.toliner.yokaidrone.ability/-command-handling-ability/index.md) | `object CommandHandlingAbility : `[`Ability`](./index.md)`<Config>` |
