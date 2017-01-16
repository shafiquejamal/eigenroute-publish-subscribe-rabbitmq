# Eigenroute Publish Subscribe

## Installation

### SBT

```
resolvers += "Eigenroute maven repo" at "http://mavenrepo.eigenroute.com/"
libraryDependencies += "com.eigenroute" % "eigenroute-publish-subscribe-minimal-scala" % "0.0.1"
```

## Use

```scala

class MyMessageSubscriber (
    override val actorSystem: ActorSystem,
  )
  extends RabbitMQPublisherSubscriber[MyMessage] {

  override val exchange: String = "some-exchange"
  override val routingActor: ActorRef = actorSystem.actorOf(RoutingActor.props, "MessageRouter")
  override val convert: (String) => Option[BrokerMessageType] = MessageBrokerMessageConverter.convert

}

class RoutingActor extends Actor with ActorLogging {

  override def receive = {

    case message : MyMessage =>
      println("MyMessage received:", message)
    case message  =>
      println("Some other message received", message)

  }

}

object RoutingActor {

  def props = Props(new RoutingActor())

}

```

Don't forget to bind routing keys to the message broker queue.