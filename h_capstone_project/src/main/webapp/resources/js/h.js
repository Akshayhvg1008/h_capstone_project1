/**
 * 
 */
	const searchFun=()=>
	{
		let filter=document.getElementById('h').value.toUpperCase();
		let m=document.getElementById('k');
		let tr=m.getElementByTagName('tr')
		for(var i=0;i<tr.length;i++)
			{
			let td=tr[i].getElementByTagName('td')[0];
			if(td)
				{
				let t=td.textContent||td.innerHTML;
				if(t.toUpperCase().indexOf(filter) > -1){
					tr[1].style.display="";
				}
				else{
					tr[i].style.display="none";
				}
				
				}
			
			}
		
	}
	
