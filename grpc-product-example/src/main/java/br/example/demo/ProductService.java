package br.example.demo;

import java.util.List;

import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;

import br.example.demo.model.ProductProto;
import br.example.demo.model.ProductProto.Product;
import br.example.demo.model.ProductProto.Products;
import br.example.demo.model.ProductServiceGrpc.ProductServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductService extends ProductServiceImplBase {
    
    @Override
    public void findAll(Empty request, StreamObserver<Products> responseObserver) {
        Product p1 = ProductProto.Product.newBuilder().setId(1).setName("Product 1").build();
        Product p2 = ProductProto.Product.newBuilder().setId(2).setName("Product 2").build();

        Products products = Products.newBuilder().addProduct(p1).addProduct(p2).build();

        responseObserver.onNext(products);
        responseObserver.onCompleted();
    }

    @Override
    public void findOneProductById(Int32Value request, StreamObserver<Product> responseObserver) {
        Product p1 = ProductProto.Product.newBuilder().setId(1).setName("Product 1").build();
        
        responseObserver.onNext(p1);
        responseObserver.onCompleted();
    }
}
