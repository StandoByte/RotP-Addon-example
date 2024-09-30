# Mixins

Since some addon devs are already using mixins, I am now obligated to make at least a short guide on them.

Mixins are a very powerful modding tool, which lets the developer manipulate the Minecraft's code. As such, it should be used sparingly, when you are absolutely sure there is no other way to implement your feature. It is also harder to debug, so be aware of that.

I recommend you read the [official Mixin wiki](https://github.com/SpongePowered/Mixin/wiki) before you start working on them - it is a nice read, and it is essential to understand the concepts it describes. There is also a [Fabric Wiki](https://fabricmc.net/wiki/tutorial:mixin_introduction) on mixins - it also applies to Forge since the library is not dependent on a mod loader, it's just that Fabric mods rely on mixins more often.

You can also technically mixin into the code of the main mod, but at least let me know what you are implementing, so that I can add a proper way of doing so into the next patch on RotP.

## [New/changed files](https://github.com/StandoByte/RotP-Addon-example/compare/master...mixins):
- `build.gradle` - adding the mixin library to the project<br>
- `mixin` package - where all the mixin classes must be created<br>
- `mixins.myrotpaddon.json` file (in `src/main/resources` directory) - all mixin classes will be defined in this file<br>
