import com.leon.test.GreetingServiceGrpc;
import com.leon.test.HelloRequest;
import com.leon.test.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SimpleGRPCClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                 .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.greeting(HelloRequest.newBuilder()
                .setUsername("Leon")
                .setPassword("Noel")
                .build()
        );

        System.out.println(response);



    }
}
