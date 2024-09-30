# Entity capability

Capabilities are Forge's way of attaching extra data to the objects that we as mod developers don't have direct contol over, namely entities, such as players. It is not perfect, as it does require some boilerplate code which may look intimidating, but it is what it is.

In this example we're adding a simple integer counter of how many pickaxes our example Steve Stand has thrown - a pretty useless piece of data, but it is here for demonstrative purposes.

This branch also implements network packets, which are essential to synchronize data between server and clients.

## [New/changed files](https://github.com/StandoByte/RotP-Addon-example/compare/master...player-capability):
- `AddonMain.java` - registering capabilities and network packets on FMLCommonSetupEvent event<br>
- Entirety of `capability` package - the data being attached to players (`LivingData` class), and the code needed for it to work<br>
- Entirety of `network` package - packets to send data between client and player<br>
- `action/ExampleStandThrowPickaxe.java` - editing the player capability
