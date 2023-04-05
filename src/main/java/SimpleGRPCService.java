import com.leon.test.GreetingServiceGrpc;
import com.leon.test.HelloRequest;
import com.leon.test.HelloResponse;
import io.grpc.stub.StreamObserver;

public class SimpleGRPCService extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hey ".concat(request.getUsername()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
