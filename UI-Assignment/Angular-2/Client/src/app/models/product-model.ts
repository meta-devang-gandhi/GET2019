export interface product{
    id : Int16Array;
    name : String;
    price : DoubleRange;
    description : String;
    imagePath : String;
    categoryName : String;
} 
    export interface products{
        products: Array<product>
     }