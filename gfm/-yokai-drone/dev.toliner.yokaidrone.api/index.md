[YokaiDrone](../index.md) / [dev.toliner.yokaidrone.api](./index.md)

## Package dev.toliner.yokaidrone.api

### Types

| Name | Summary |
|---|---|
| [Abilities](-abilities.md) | `object Abilities` |
| [Ability](-ability/index.md) | Ability is a configurable function for [Yokai](-yokai/index.md). When the Ability is gained by [Yokai](-yokai/index.md), it should configure [JDABuilder](https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/JDABuilder.html) based on config to capture event from Discord. **All implementation should be object-declaration**`interface Ability<T : `[`AbilityConfig`](-ability-config.md)`>` |
| [AbilityConfig](-ability-config.md) | Empty interface for configuration of [Ability](-ability/index.md).`interface AbilityConfig` |
| [DependencyMap](-dependency-map/index.md) | `class DependencyMap` |
| [Yokai](-yokai/index.md) | Interface for Yokai, which is one set of bot functions. The first thing you should do when you build bot is choose or implement Yokai. Yokai must be specified by command-line argument, then all specified Yokai is loaded by bootstrap. Each Yokai can have some [Ability](-ability/index.md). You can gain and configure [Ability](-ability/index.md)s by overriding [init](-yokai/init.md) method. **All implementation must have non-parameter constructor.**`interface Yokai` |

### Functions

| Name | Summary |
|---|---|
| [gainAbility](gain-ability.md) | An helper function to gain ability. By using this in [Yokai.init](-yokai/init.md), Yokai can gain and configure [Ability](-ability/index.md)s.`fun <T : `[`AbilityConfig`](-ability-config.md)`> `[`Yokai`](-yokai/index.md)`.gainAbility(ability: `[`Ability`](-ability/index.md)`<T>, configure: T.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
