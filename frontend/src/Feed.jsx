import { useEffect, useState } from "react";
import Post from "./Components/Post";
import urls from './url.json';
import AddPost from "./Components/AddPost";

const Feed = () => {

    const [data,setdata]=useState([]);
    
    const fetchData = async () => {
        try {
            const response = await fetch(urls.Blog+"/blogs/getblogs");
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            const json_data = await response.json();
            
            setdata(json_data);
            
        } catch (error) {
        
           
            setdata([]);
        }
    };
    useEffect(() =>{
        fetchData();
        const caller=setInterval(()=>{
           fetchData();

       },2000);
       return () => clearInterval(caller);
            },[]);
    return ( <>
    <div className="container bg">
       <AddPost/>
    {data.map((blog)=>( <Post key={blog.id} blog={blog}/>))}
    
    </div>
    </> );
}
 
export default Feed;