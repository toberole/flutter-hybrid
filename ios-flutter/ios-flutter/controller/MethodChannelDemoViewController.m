#import "MethodChannelDemoViewController.h"

@interface MethodChannelDemoViewController ()

@property(nonatomic,strong)FlutterMethodChannel*mc;

@end

@implementation MethodChannelDemoViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    NSLog(@"MethodChannelDemoViewController#viewDidLoad ......");
}

- (void)viewDidAppear:(BOOL)animated{
    [self initMethodChannel];
    NSLog(@"MethodChannelDemoViewController#viewDidAppear ......");
}

-(void)initMethodChannel{
    self.mc = [FlutterMethodChannel methodChannelWithName:@"MethodChannelDemo" binaryMessenger:(NSObject<FlutterBinaryMessenger>*)self];
    
    [self.mc setMethodCallHandler:^(FlutterMethodCall * _Nonnull call, FlutterResult  _Nonnull result) {
        NSLog(@"call.method: %@",call.method);
        if ([call.method isEqualToString:@"flutter_call_native"]) {
            NSUInteger count = [call.arguments count];
            NSLog(@"call.arguments count: %lu",(unsigned long)count);
            NSString*str = [call.arguments objectAtIndex:0];
            NSLog(@"call.arguments objectAtIndex:0 str: %@",str);
            
            int i = [[call.arguments objectAtIndex:1]intValue];
            NSLog(@"call.arguments objectAtIndex:1 i: %d",i);
        }else if ([call.method isEqualToString:@"transfer_data1"]) {
            int i = [call.arguments intValue];
            NSLog(@"call.arguments objectAtIndex:1 i: %d",i);
        }else if ([call.method isEqualToString:@"transfer_data_map"]) {
            NSDictionary*dict = call.arguments;
            NSLog(@"call.arguments dic['1']: %@",dict[@"1"]);
        }else if ([call.method isEqualToString:@"transfer_data_list"]) {
            NSArray*arr = call.arguments;
            // [1, "hello", false, 0.1]
            int arr_0 = [[arr objectAtIndex:0]intValue];
            NSLog(@"arr_0: %d",arr_0);
            NSString*arr_1 = [arr objectAtIndex:1];
            NSLog(@"arr_1: %@",arr_1);
            BOOL arr_2 = [[arr objectAtIndex:2]boolValue];
            NSLog(@"arr_2: %d",arr_2);
        }
        
        
    }];
}



@end
