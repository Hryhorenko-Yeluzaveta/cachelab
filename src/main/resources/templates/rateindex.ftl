<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h2>Save Rate</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>image</th>

    </tr>
    </thead>
    <tbody>

    <form action="/saverate" method="post">
        <tr>
            <td>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="name">
            </td>
            <td>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" placeholder="price">
            </td>
            <td>
                <label for="image">Image</label>
                <input type="text" id="image" name="image" placeholder="link">
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="add">
            </td>
        </tr>
    </form>

    </tbody>

</table>

<h2>List of Rates</h2>
<ul>
    <#if rate??>
        <#list rate as rate>
            <li>
                <a href="/rate/${rate.id}">${rate.name}</a>
            </li>
        </#list>
    </#if>
</ul>

<h2>Update/Delete Rate</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>
    <#if rate??>
        <#list rate as rate>
            <form action="/updaterate" method="post">
                <tr>
                    <td>
                        <input type="hidden" name="id" value="${rate.id}">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="${rate.name}">
                    </td>
                    <td>
                        <label for="price">Price</label>
                        <input type="text" id="price" name="price" value="${rate.price}">
                    </td>
                    <td>
                        <label for="image">Image</label>
                        <input type="text" id="image" name="image" value="${rate.image}">
                    </td>
                    <td>
                        <button type="submit">update</button>
                    </td>

            </form>
            <form action="/deleterate" method="post">
                <input type="hidden" name="id" value="${rate.id}">
                <td>
                    <input type="submit" value="delete">
                </td>
            </form>

            </tr>
        </#list>
    </#if>
    </tbody>
</table>

<h2> Delete Rate </h2>


<form action="/deleterate" method="post">
    <select name="id">
        <#if rate??>
            <#list rate as rate>
                <li>
                    <option value="${rate.id}">${rate.name}</option>
                </li>
            </#list>
        </#if>
    </select>
    <button type="submit">delete</button>
</form>

<a href="/"> GO TO CATEGORIES </a>


</body>
</html>