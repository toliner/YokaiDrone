[YokaiDrone](../index.md) / [dev.toliner.yokaidrone.api](index.md) / [gainAbility](./gain-ability.md)

# gainAbility

`fun <T : `[`AbilityConfig`](-ability-config.md)`> `[`Yokai`](-yokai/index.md)`.gainAbility(ability: `[`Ability`](-ability/index.md)`<T>, configure: T.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/toliner/YokaiDrone/tree/master/src/main/kotlin/dev/toliner/yokaidrone/api/Yokai.kt#L38)

An helper function to gain ability.
By using this in [Yokai.init](-yokai/init.md), Yokai can gain and configure [Ability](-ability/index.md)s.

### Parameters

`ability` - An [Ability](-ability/index.md) to gain.

`configure` - configure [AbilityConfig](-ability-config.md) in this lambda.