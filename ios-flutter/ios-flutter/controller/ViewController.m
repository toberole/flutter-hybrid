#import <Flutter/Flutter.h>
#import "ViewController.h"
#import "AppDelegate.h"

@interface ViewController()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    UIButton*btn1 = [self.view viewWithTag:1];
    [btn1 addTarget:self action:@selector(btn1_clicked) forControlEvents:UIControlEventTouchUpInside];
    
    UIButton*btn2 = [self.view viewWithTag:2];
    [btn2 addTarget:self action:@selector(btn2_clicked) forControlEvents:UIControlEventTouchUpInside];
}

-(void)btn1_clicked{
    NSLog(@"btn1_clicked ......");
    
    FlutterEngine *flutterEngine = [(AppDelegate *)[[UIApplication sharedApplication] delegate] flutterEngine];
    FlutterViewController *flutterViewController = [[FlutterViewController alloc] initWithEngine:flutterEngine nibName:nil bundle:nil];
    [flutterViewController setInitialRoute:@"route2"];
    flutterViewController.modalPresentationStyle = UIModalPresentationFullScreen;
    [self presentViewController:flutterViewController animated:false completion:nil];
}

-(void)btn2_clicked{
}
@end
