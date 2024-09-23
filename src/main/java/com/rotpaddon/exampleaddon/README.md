# Entity capability

Capabilities are Forge's way of attaching extra data to the objects that we as mod developers don't have direct contol over, namely entities, such as players. It is not perfect, as it does require some boilerplate code which may look intimidating, but it is what it is.

In this example we're adding a simple integer counter of how many pickaxes our example Steve Stand has thrown - a pretty useless piece of data, but it is here for demonstrative purposes.

This branch also implements network packets, which are essential to synchronize data between server and clients.
