[YokaiDrone](../../index.md) / [dev.toliner.yokaidrone.api](../index.md) / [Yokai](./index.md)

# Yokai

`interface Yokai` [(source)](https://github.com/toliner/YokaiDrone/tree/master/src/main/kotlin/dev/toliner/yokaidrone/api/Yokai.kt#L22)

Interface for Yokai, which is one set of bot functions.
The first thing you should do when you build bot is choose or implement Yokai.
Yokai must be specified by command-line argument, then all specified Yokai is loaded by bootstrap.
Each Yokai can have some [Ability](../-ability/index.md).
You can gain and configure [Ability](../-ability/index.md)s by overriding [init](init.md) method.
**All implementation must have non-parameter constructor.**

**Author**
toliner

### Functions

| Name | Summary |
|---|---|
| [init](init.md) | This method is called by bootstrap at first. You can configure all about [Yokai](./index.md), including [Ability](../-ability/index.md)s. If this method is not called, the [Yokai](./index.md) is not loaded.`abstract fun init(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [gainAbility](../gain-ability.md) | An helper function to gain ability. By using this in [Yokai.init](init.md), Yokai can gain and configure [Ability](../-ability/index.md)s.`fun <T : `[`AbilityConfig`](../-ability-config.md)`> `[`Yokai`](./index.md)`.gainAbility(ability: `[`Ability`](../-ability/index.md)`<T>, configure: T.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
